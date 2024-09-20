import * as React from "react";
import dayjs from "dayjs";
import { styled, alpha } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import InputBase from "@mui/material/InputBase";
import SearchIcon from "@mui/icons-material/Search";
import Button from "@mui/material/Button";
import TextField from '@mui/material/TextField';
import { saveAs } from "file-saver";
import Autocomplete from '@mui/material/Autocomplete';
import Table from "./Components/Table";
import { getTrans, getAllShops, getAfterTrans, exportBefore, exportAfter } from "./API/ApiCaller";

const Search = styled("div")(({ theme }) => ({
  position: "relative",
  borderRadius: theme.shape.borderRadius,
  backgroundColor: alpha("#d7d7d7", 0.85),
  "&:hover": {
    backgroundColor: alpha("#d7d7d9", 1),
  },
  width: "100%",
  [theme.breakpoints.up("sm")]: {
    width: "auto",
  },
}));

const SearchIconWrapper = styled("div")(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: "100%",
  position: "absolute",
  pointerEvents: "none",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: "inherit",
  width: "100%",
  "& .MuiInputBase-input": {
    padding: theme.spacing(1, 1, 1, 0),
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create("width"),
    [theme.breakpoints.up("sm")]: {
      width: "12ch",
      "&:focus": {
        width: "20ch",
      },
    },
  },
}));

export default function Dashboard({ toggleLoader }) {
  const [shops, setShops] = React.useState([]);
  const [searchQuery, setSearchQuery] = React.useState("All Shops");
  const [isCollapsed, setIsCollapsed] = React.useState(true);
  const [searchLocation, setSearchLocation] = React.useState("");
  const [responseResult, setResponseResult] = React.useState({ "page": 1, "list": [] });
  const [selectedFilter, setSelectedFilter] = React.useState([
    { "Recent": dayjs().subtract(0, 'days'), apply: false },
    { "Last 3 month and before": dayjs().subtract(3, 'month'), apply: false },
    { "Last 6 months and before ": dayjs().subtract(6, 'month'), apply: false },
    { "Last 9 months and before": dayjs().subtract(9, 'month'), apply: false },
    { "Last 12 months and before": dayjs().subtract(12, 'month'), apply: false },
    { "Last 24 months and before": dayjs().subtract(24, 'month'), apply: false }
  ]);
  const [exporting, setExporting] = React.useState(false);
  const handleInputChange = (event, newValue) => {
    setSearchQuery(newValue);
  };

  const handleSearchLocationChange = (event) => {
    setSearchLocation(event.target.value);
  };

  const toggleCollapse = () => {
    setIsCollapsed((prev) => !prev);
  };

  const getResults = async (pageNum) => {
    toggleLoader();
    try {

      const activeFilterDate = selectedFilter
        .filter(filter => filter.apply)
        .map(filter => Object.values(filter)[0])
        .map(date => dayjs(date).format('YYYY-MM-DD'));

      const date = activeFilterDate.length ? activeFilterDate[0] : dayjs().add(1, 'day').format('YYYY-MM-DD');
      if (selectedFilter[0]?.apply) {
        console.log("First filter is applied. Date:", dayjs().subtract(3, 'month').format("YYYY-MM-DD"));

        const response = await getAfterTrans(searchQuery, dayjs().subtract(3, 'month').format("YYYY-MM-DD"), searchLocation, pageNum);
        setResponseResult(response);
      } else {

        const response = await getTrans(searchQuery, date, searchLocation, pageNum);
        setResponseResult(response);
      }
    }
    catch (e) {
      console.log(e)
    } finally {
      toggleLoader();
    }
  };

  const searchResults = () => {
    getResults(1);
  };
  const exportIntoCSV = () => {
    const downloadCSVResult = async (shop, date, location, isBefore) => {
      setExporting(true);
      try {
        let data = null;

        if (isBefore) {
          data = await exportBefore(shop, date, location);
        } else {
          data = await exportAfter(shop, date, location);
        }

        const jsonToCSV = (jsonData) => {
          const headers = Object.keys(jsonData[0]).join(","); // Get headers from the first object
          const rows = jsonData.map(obj =>
            Object.values(obj).map(value => `"${value}"`).join(",") // Wrap values in quotes to handle commas
          ).join("\n");

          return `${headers}\n${rows}`;
        };

        const csvData = jsonToCSV(data);

        const blob = new Blob([csvData], { type: "text/csv;charset=utf-8;" });
        saveAs(blob, `${searchQuery}-${dayjs().format("YYYY-MM-DD")}.csv`);
      }
      catch (e) {
        console.log(e);
      } finally {
        setExporting(false);
      }
    }


    const activeFilterDate = selectedFilter
      .filter(filter => filter.apply)
      .map(filter => Object.values(filter)[0])
      .map(date => dayjs(date).format('YYYY-MM-DD'));

    const date = activeFilterDate.length ? activeFilterDate[0] : dayjs().add(1, 'day').format('YYYY-MM-DD');
    if (selectedFilter[0]?.apply) {
      console.log("First filter is applied. Date:", dayjs().subtract(3, 'month').format("YYYY-MM-DD"));

      downloadCSVResult(searchQuery, dayjs().subtract(3, 'month').format("YYYY-MM-DD"), searchLocation, false);
    } else {

      downloadCSVResult(searchQuery, date, searchLocation, true);
    }

  }

  const gotoNextPage = () => {
    getResults(responseResult.page + 1);
  };

  const gotoPrevPage = () => {
    if (responseResult.page > 1) {
      getResults(responseResult.page - 1);
    }
  };

  React.useEffect(() => {
    const fetchData = async () => {
      toggleLoader();
      try {
        const response = await getAllShops();
        setShops([{ shopName: "All Shops" }, ...response]);
        await getResults(1);
      } catch (error) {
        console.error("Error fetching data:", error);
      } finally {
        toggleLoader();
      }
    };

    fetchData();
  }, []);// searchQuery, searchLocation, selectedFilter

  const handleFilterChange = (index) => {
    // setSelectedFilter(prevFilters=>{
    //   prevFilters.map((item,index)=>
    //   index!=index ? {...item,apply:false} : {...item,apply:!item.apply}
    //   )
    // })
    setSelectedFilter(prevFilters =>
      prevFilters.map((item, idx) =>
        idx === index ? { ...item, apply: !item.apply } : { ...item, apply: false }
      )
    );
  };
  const handleCheckboxChange = (fieldName) => {
    setSelectedFilter(selectedFilter === fieldName ? null : fieldName); // Toggle the selected filter
  };

  const shopNames = shops.map(shop => shop.shopName);

  return (
    <Box sx={{ flexGrow: 1, width: "100vw", height: "100vh" }}>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" noWrap component="div" sx={{ flexGrow: 1, display: { xs: "none", sm: "block" } }}>
            Nstyle
          </Typography>
        </Toolbar>
      </AppBar>

      <Box sx={{ display: "flex", alignItems: "center", p: 2, gap: 4, width: "100%" }}>
        <Autocomplete
          disablePortal
          options={shopNames}
          sx={{ width: 300 }}
          renderInput={(params) => <TextField {...params} label={searchQuery} />}
          onChange={handleInputChange}
        />
        <Search sx={{ flexGrow: 1 }}>
          <SearchIconWrapper>
            <SearchIcon />
          </SearchIconWrapper>
          <StyledInputBase
            placeholder="Location"
            inputProps={{ "aria-label": "search" }}
            value={searchLocation}
            onChange={handleSearchLocationChange}
          />
        </Search>
        <Box sx={{ display: "flex", alignItems: "center", gap: 2, width: "40%", position: "relative" }}>
          <Box
            onClick={toggleCollapse}
            sx={{ position: "relative", border: "1px solid #b0b0b0", borderRadius: "8px", width: "48%", p: 1.5, cursor: "pointer", backgroundColor: "white", zIndex: 1100 }}
          >
            <Typography variant="body2" sx={{ display: "flex", alignItems: "center", justifyContent: "space-between" }}>
              <span>Filter</span>
              <span>{isCollapsed ? "▼" : "▲"}</span>
            </Typography>
            {!isCollapsed && (
              <Box sx={{ position: "absolute", top: "100%", left: 0, right: 0, backgroundColor: "white", border: "1px solid #b0b0b0", borderRadius: "8px", p: 2, zIndex: 1200 }}>
                {selectedFilter.map((item, index) => {
                  const [text, value] = Object.entries(item)[0];
                  return (
                    <label key={index} className="flex items-center text-sm text-[#616161]">
                      <input
                        type="checkbox"
                        checked={item.apply}
                        onChange={() => handleFilterChange(index)}
                        className="mr-1 h-4 w-4 text-[#616161] border-[#b0b0b0] rounded"
                      />
                      <span>{text}</span>
                    </label>
                  );
                })}
              </Box>
            )}
          </Box>

          <Button
            variant="contained"
            sx={{ background: "#1976D2", color: "white", fontWeight: "bold", borderRadius: "8px", width: "150px", px: 3, py: 1, fontSize: "0.875rem" }}
            onClick={searchResults}
          >
            Search
          </Button>

          <Button
            variant="contained"
            sx={{ background: "#1976D2", color: "white", fontWeight: "bold", borderRadius: "8px", width: "150px", px: 3, py: 1, fontSize: "0.875rem" }}
            onClick={exportIntoCSV}
            disabled={exporting}
          >
            <div className={`mr-3 ${exporting ? "block" : "hidden"}`}>


              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 100 100"
                width="20px"
                height="20px"
                fill="none"
                stroke="white"
                strokeWidth="8"
                strokeLinecap="round"
                style={{
                  animation: "rotate 1s infinite linear",
                  transformOrigin: "50% 50%",
                }}
              >
                <style>
                  {`

      @keyframes rotate {
        from { transform: rotate(0deg); }
        to { transform: rotate(360deg); }
      }
    `}
                </style>
                <circle cx="50" cy="50" r="45" strokeOpacity="0.2" />
                <circle cx="50" cy="50" r="45" strokeDasharray="283" strokeDashoffset="75" />
              </svg>
            </div>
            Export
          </Button>
        </Box>
      </Box>
      <Table shopsLst={responseResult?.list} />
      <div className="flex justify-end space-x-4 px-5">
        <button
          onClick={gotoPrevPage}
          className="bg-[#1976D2] text-white font-bold py-2 px-4 rounded hover:bg-blue-700 transition-colors duration-300"
          disabled={responseResult.page <= 1}
        >
          &#x2190; Prev
        </button>
        <button
          onClick={gotoNextPage}
          className="bg-[#1976D2] text-white font-bold py-2 px-4 rounded hover:bg-blue-700 transition-colors duration-300"
          disabled={responseResult?.list.length === 0}
        >
          Next &#x2192;
        </button>
      </div>
    </Box>
  );
}

import * as React from "react";
import { styled, alpha } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import InputBase from "@mui/material/InputBase";
import SearchIcon from "@mui/icons-material/Search";
import DataTable from "./Components/DataTable";
import dayjs from "dayjs";
import Button from "@mui/material/Button";
import Datepicker from "react-tailwindcss-datepicker";
import axios from "axios";
import { saveAs } from "file-saver";
import Papa from "papaparse";
import API_ENDPOINTS from "./API/apiEndpoints";

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

const formatDateForAPI = (date) => {
  return dayjs(date).format('YYYY-MM-DD');
};

export default function Dashboard({ toggleLoader }) {
  const [searchQuery, setSearchQuery] = React.useState("");
  const [filteredRows, setFilteredRows] = React.useState([]);
  const [displayRow, setDisplayRows] = React.useState([]);
  const [isCollapsed, setIsCollapsed] = React.useState(true);
  const [searchLocation,setSearchLocation]=React.useState("");
  const [selectedFilter, setSelectedFilter] = React.useState([
    { "Recent": dayjs().subtract(0, 'days'), apply: false },
    { "Last 3 month and before": dayjs().subtract(3, 'month'), apply: false },
    { "Last 6 months and before ":dayjs().subtract(6, 'month'), apply: false },
    { "Last 9 months and before": dayjs().subtract(9, 'month'), apply: false },
    { "Last 12 months and before":dayjs().subtract(12, 'month'), apply: false },
    { "Last 24 months and before": dayjs().subtract(24, 'month'), apply: false }
  ]);


  const [selectedDateRange, setSelectedDateRange] = React.useState({
    startDate: null,
    endDate: null
  });

  const handleInputChange = (event) => {
    const query = event.target.value;
    setSearchQuery(query);
    applyFilters(selectedFilter, searchLocation, query);
  };
  
  const handleSearchLocationChange = (event) => {
    const query = event.target.value;
    setSearchLocation(query);
    applyFilters(selectedFilter, query, searchQuery);
  };
  
  const applyFilters = (tempFilter, locationQuery=null, nameQuery=null) => {
    let results = filteredRows;
  
    // Apply text search filters
    if(nameQuery!=null){
    const lowercasedNameQuery = nameQuery.toLowerCase();
    results = results.filter((row) =>
      row.shopName && row.shopName.toLowerCase().includes(lowercasedNameQuery)
    );}
    if(locationQuery!=null){
    // Apply location search filters
    const lowercasedLocationQuery = locationQuery.toLowerCase();
    results = results.filter((row) =>
      row.shopLocation && row.shopLocation.toLowerCase().includes(lowercasedLocationQuery)
    );}
  
    // Apply selected time filters
    const selectedFilters = tempFilter
      .filter((filter) => filter.apply)
      .map((filter) => {
        const [text, date] = Object.entries(filter)[0];
        return { text, date };
      });
  
    if (selectedFilters.length > 0) {
      results = results.filter((row) => {
        const lastVisit = dayjs(row.lastVisit);
        return selectedFilters.some((filter) => {
          if (filter.text === "Recent") {
            // Filter for "Recent" within the last 3 months
            return lastVisit.isAfter(dayjs().subtract(3, 'month'), 'day');
          }
          return lastVisit.isBefore(filter.date, 'day') || lastVisit.isSame(filter.date, 'day');
        });
      });
    }
  
    setDisplayRows(results);
  };
  

  const handleDateChange = (newValue) => {
    setSelectedDateRange(newValue);
  };

  const toggleCollapse = () => {
    setIsCollapsed((prev) => !prev);
  };

  const handleFilterChange = (index) => {
    let tempFilter = selectedFilter.map((filter, i) =>
        i === index ? { ...filter, apply: !filter.apply } : filter
      )
    setSelectedFilter((prevFilters) =>
      prevFilters.map((filter, i) =>
        i === index ? { ...filter, apply: !filter.apply } : filter
      )
    );

    applyFilters(tempFilter);
  };


  React.useEffect(() => {
    const fetchCustomers = async () => {
      try {
        let { startDate, endDate } = selectedDateRange;
        if (!startDate || !endDate) {
          startDate= dayjs().add(1, 'day').format('YYYY-MM-DD');
          endDate= dayjs().add(1, 'day').format('YYYY-MM-DD');
        }
        toggleLoader();
        const response = await axios.post(API_ENDPOINTS.GET_CUSTOMERS, {
          startDate: formatDateForAPI(startDate),
          endDate: formatDateForAPI(endDate)
        });
        toggleLoader();

        const categdata=categorizeData(response.data);
     
        setFilteredRows(categdata);
        setDisplayRows(categdata);
      } catch (error) {
        console.error("Error fetching data", error);
      }
    };

    fetchCustomers();
  }, [selectedDateRange]);


  const categorizeData = (data) => {
    const now = dayjs();
    const timeFrames = {
      '24 months': now.subtract(24, 'month'),
      '12 months': now.subtract(12, 'month'),
      '9 months': now.subtract(9, 'month'),
      '6 months': now.subtract(6, 'month'),
      '3 months': now.subtract(3, 'month'),
    };
  
    return data.map(item => {
      const lastVisit = dayjs(item.lastVisit);
      let category = 'Recent';
  
      if (lastVisit.isBefore(timeFrames['24 months'])) {
        category = 'Before 24 months';
      } else if (lastVisit.isBefore(timeFrames['12 months'])) {
        category = 'Before 12 months';
      } else if (lastVisit.isBefore(timeFrames['9 months'])) {
        category = 'Before 9 months';
      } else if (lastVisit.isBefore(timeFrames['6 months'])) {
        category = 'Before 6 months';
      } else if (lastVisit.isBefore(timeFrames['3 months'])) {
        category = 'Before 3 months';
      }
  
      return { ...item, category };
    });
  };
  React.useEffect(() => {
    const getInitialResults = async () => {
      const tomorrow = dayjs().add(1, 'day').format('YYYY-MM-DD');
      try {

        toggleLoader();
        const response = await axios.post(API_ENDPOINTS.GET_CUSTOMERS, {
          startDate: formatDateForAPI(tomorrow),
          endDate: formatDateForAPI(tomorrow)
        });
        toggleLoader();
      
        const categdata=categorizeData(response.data);
     
        setFilteredRows(categdata);
        setDisplayRows(categdata);
      
      } catch (error) {
        console.error("Error fetching data", error);
      }
    }

    getInitialResults();
  }, []);

  const exportToCSV = () => {
    if (displayRow.length === 0) {
      alert("Nothing to export");
      return;
    }
    const timestamp = new Date().toISOString().replace(/[:.-]/g, "");
    const filename = `filtered_data_${timestamp}.csv`;
    const csv = Papa.unparse(displayRow);
    const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
    saveAs(blob, filename);
  };

  
  return (
    <Box sx={{ flexGrow: 1, width: "100vw" }}>
      <AppBar position="static">
        <Toolbar>
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{ flexGrow: 1, display: { xs: "none", sm: "block" } }}
          >
            NyStyle
          </Typography>
        </Toolbar>
      </AppBar>

      <Box
        sx={{
          display: "flex",
          alignItems: "center",
          p: 2,
          gap: 4,
          width: "100%",
        }}
      >
        <Search sx={{ flexGrow: 1 }}>
          <SearchIconWrapper >
            <SearchIcon />
          </SearchIconWrapper>
          <StyledInputBase
            placeholder="Shop"
            inputProps={{ "aria-label": "search" }}
            value={searchQuery}
            onChange={handleInputChange}

          />
        </Search>
        <Search sx={{ flexGrow: 1 }}>
          <SearchIconWrapper >
            <SearchIcon />
          </SearchIconWrapper>
          <StyledInputBase
            placeholder="Location"
            inputProps={{ "aria-label": "search" }}
            value={searchLocation}
            onChange={handleSearchLocationChange}

          />
        </Search>
        {/* Container for Datepicker and Export Button */}
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            gap: 2,
            width: "40%",
            position: "relative",
          }}
        >
          <div className="border b-1 rounded-lg">
            <Datepicker
              value={selectedDateRange}
              onChange={handleDateChange}
              showShortcuts={true}
            />
          </div>
          <Button
            variant="contained"
            sx={{
              background: "#1976D2",
              color: "white",
              fontWeight: "bold",
              borderRadius: "8px",
              px: 3,
              py: 1,
              fontSize: "0.875rem",
            }}
            onClick={exportToCSV}
          >
            Export
          </Button>

          <Box
            onClick={toggleCollapse}
            sx={{
              position: "relative",
              border: "1px solid #b0b0b0",
              borderRadius: "8px",
              width: "48%",
              p: 1.5,
              cursor: "pointer",
              backgroundColor: "white",
              zIndex: 1100, // Higher than other elements
            }}
          >
            <Typography
              variant="body2"
              sx={{ display: "flex", alignItems: "center", justifyContent: "space-between" }}
            >
              <span>Filter</span>
              <span>{isCollapsed ? "▼" : "▲"}</span>
            </Typography>
            {!isCollapsed && (
              <Box
                sx={{
                  position: "absolute",
                  top: "100%",
                  left: 0,
                  right: 0,
                  backgroundColor: "white",
                  border: "1px solid #b0b0b0",
                  borderRadius: "8px",
                  p: 2,
                  zIndex: 1200, // Ensure it's above other elements
                }}
              >

                {selectedFilter.map((item, index) => {
                  const [text, value] = Object.entries(item)[0];
                  return (
                    <label
                      key={index}
                      className="flex items-center text-sm text-[#616161]"
                    >
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
        </Box>
      </Box>

      <DataTable rows={displayRow} setDisplayRows={setDisplayRows} />
    </Box>
  );
}

import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";

const columns = [
  { field: "firstname", headerName: "First Name", width: 150 },
  { field: "lastname", headerName: "Last Name", width: 150},
  {
    field: "mobileNo",
    headerName: "Mobile No",
    width: 150,
    valueGetter: (value, row) => row.mobileNo || "N/A",
  },
  { field: "email", headerName: "Email", width: 200 },
  {
    field: "Last Visit Store",
    headerName: "Shop Name",
    width: 150,
    valueGetter: (value, row) => row.shopName || "N/A",
  },
  {
    field: "lastVisit",
    headerName: "Last Visit",
    type: "string",
    width: 150,
    valueGetter: (value, row) =>
      row.lastVisit || null,
  },
  {
    field: "firstVisit",
    headerName: "First Visit",
    type: "string",
    width: 150,
    valueGetter: (value, row) =>
      row.firstVisit || null,
  },
  { field: "visitCounts", headerName: "Visit Count", width: 150 },
  { field: "shopLocation", headerName: "Shop Location", width: 150 },
  { field: "category", headerName: "Visit Info", width: 150,valueGetter: (value, row) =>
    row.category || null,},
];

export default function DataTable({ rows }) {

  return (
    <div style={{ height: 400, width: "100%", padding: "20px 20px 0 20px" }}>
      <DataGrid
        rows={rows}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: { page: 0, pageSize: 5 },
          },
        }}
        pageSizeOptions={[5, 10]}
      />
    </div>
  );
}

import React from 'react';
import dayjs from 'dayjs'; // Import dayjs for date formatting
import utc from 'dayjs/plugin/utc';

const Table = ({ shopsLst }) => {
  const fields = [
    { fieldName: "id", displayName: "Id" },
    { fieldName: "firstname", displayName: "First Name" },
    { fieldName: "lastname", displayName: "Last Name" },
    { fieldName: "email", displayName: "Email" },
    { fieldName: "firstVisit", displayName: "First" },
    { fieldName: "lastVisit", displayName: "Last" },
    { fieldName: "visitCounts", displayName: "Count" },
    { fieldName: "status", displayName: "Status" },
    { fieldName: "shopName", displayName: "Shop Name" },
    { fieldName: "shopLocation", displayName: "Location" },
    { fieldName: "homeno", displayName: "Home #" },
    { fieldName: "mobileNo", displayName: "Mobile" },
    { fieldName: "addr1", displayName: "Addr" }
  ];
  dayjs.extend(utc);
  // const formatDate = (timestamp) => {
  //   return dayjs.unix(timestamp/1000).utc().format('YYYY-MM-DD');
  // };

  const renderCell = (fieldName, value) => {
    switch (fieldName) {
      case "firstVisit":
      case "lastVisit":
        return value; // Format dates
      case "addr1":
        return value && value.length > 20 ? `${value.substring(0, 20)}...` : value || '-'; // Truncate address
      default:
        return value !== null && value !== "" ? value : '-'; // Default case
    }
  };

  return (
    <div className='px-5'>
      <div className="relative min-h-96 overflow-x-auto">
        <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
              {fields.map((item) => (
                <th key={item.fieldName} scope="col" className="px-2 py-3 text-center text-nowrap">
                  {item.displayName}
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {
              shopsLst.map((shop, index) => (
                <tr key={shop.id || index} className="bg-white dark:bg-gray-800">
                  {fields.map((field) => (
                    <td key={field.fieldName} className="px-3 py-1 text-center text-nowrap">
                      {renderCell(field.fieldName, shop[field.fieldName])} {/* Render cell content */}
                    </td>
                  ))}
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
      
    </div>
  );
};

export default Table;

/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: ['none', '&:not(.light *)'],
  content: [
    "./src/**/*.{js,jsx}",
    "./node_modules/react-tailwindcss-datepicker/dist/index.esm.js"
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}


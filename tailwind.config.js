/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx,vue}",
  ],
  theme: {
    extend: {
        colors: {
                palette: {
                    100: '#F4EEE0',
                    200: '#6D5D6E',
                    300: '#4F4557',
                    400: '#393646',
                }
            }
    },
  },
  plugins: [],
}

import { Outlet } from "react-router-dom";
import { Box } from "@mui/material";
import Sidebar from "../components/Sidebar";
import Topbar from "../components/Topbar";

const Layout = () => {
  return (
    <Box display="flex" flexDirection="column" height="100vh">
      <Topbar />
      <Box display="flex" flex={1}>
        <Sidebar />
        <Box component="main" flex={1} p={3}>
          <Outlet />
        </Box>
      </Box>
    </Box>
  );
};

export default Layout;

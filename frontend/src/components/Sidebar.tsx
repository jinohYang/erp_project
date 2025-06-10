import { Box, List, ListItemButton, ListItemText } from "@mui/material";
import { Link } from "react-router-dom";

const Sidebar = () => {
  return (
    <Box width="200px" bgcolor="grey.200" height="100%" p={2}>
      <List>
        <ListItemButton component={Link} to="/">
          <ListItemText primary="대시보드" />
        </ListItemButton>
        <ListItemButton component={Link} to="/employee">
          <ListItemText primary="직원관리" />
        </ListItemButton>
        <ListItemButton component={Link} to="/attendance">
          <ListItemText primary="근태관리" />
        </ListItemButton>
        <ListItemButton component={Link} to="/accounting">
          <ListItemText primary="회계관리" />
        </ListItemButton>
        <ListItemButton component={Link} to="/stock">
          <ListItemText primary="재고관리" />
        </ListItemButton>
        <ListItemButton component={Link} to="/mypage">
          <ListItemText primary="내 정보" />
        </ListItemButton>
      </List>
    </Box>
  );
};

export default Sidebar;

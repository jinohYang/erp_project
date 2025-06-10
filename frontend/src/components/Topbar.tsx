import { AppBar, Toolbar, Typography, Button } from "@mui/material";

const Topbar = () => {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          My ERP
        </Typography>
        <Button color="inherit">로그아웃</Button>
      </Toolbar>
    </AppBar>
  );
};

export default Topbar;

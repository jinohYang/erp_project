import React from "react";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import Typography from "@mui/material/Typography";

const DashboardPage = () => {
  return (
    <Box>
      <Typography variant="h5" mb={3}>대시보드</Typography>
      <Grid container spacing={2}>
        <Grid item xs={4}>
          <Paper elevation={2} sx={{ p: 2 }}>
            <Typography>직원 수: 10명</Typography>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper elevation={2} sx={{ p: 2 }}>
            <Typography>근무중: 3명</Typography>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper elevation={2} sx={{ p: 2 }}>
            <Typography>재고 수량: 52건</Typography>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default DashboardPage;

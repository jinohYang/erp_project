import { Box, Button, TextField, Typography } from "@mui/material";

const LoginPage = () => {
  return (
    <Box display="flex" flexDirection="column" alignItems="center" mt={10}>
      <Typography variant="h4" gutterBottom>MyERP 로그인</Typography>
      <Box width="300px" display="flex" flexDirection="column" gap={2}>
        <TextField label="아이디" variant="outlined" />
        <TextField label="비밀번호" type="password" variant="outlined" />
        <Button variant="contained">로그인</Button>
      </Box>
    </Box>
  );
};

export default LoginPage;

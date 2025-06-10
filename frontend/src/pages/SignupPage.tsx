import { Box, TextField, Button, Typography } from "@mui/material";

const SignupPage = () => {
  return (
    <Box display="flex" flexDirection="column" alignItems="center" mt={10}>
      <Typography variant="h4" gutterBottom>회원가입</Typography>
      <Box width="300px" display="flex" flexDirection="column" gap={2}>
        <TextField label="아이디" variant="outlined" />
        <TextField label="비밀번호" type="password" variant="outlined" />
        <TextField label="비밀번호 확인" type="password" variant="outlined" />
        <TextField label="이름" variant="outlined" />
        <TextField label="이메일" variant="outlined" />
        <TextField label="연락처" variant="outlined" />
        <Button variant="contained">회원가입</Button>
      </Box>
    </Box>
  );
};

export default SignupPage;

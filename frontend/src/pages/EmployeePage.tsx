import React, { useState } from "react";
import {
  Box,
  Button,
  Typography,
  Paper,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Dialog,
} from "@mui/material";
import EmployeeFormDialog from "../components/EmployeeFormDialog";

// 더미 직원(=Employee) 데이터
const initialEmployeeList = [
  { id: 1, name: "홍길동", dept: "HR", position: "Assistant Manager", phone: "010-1234-5678", status: "재직" },
  { id: 2, name: "김영희", dept: "Dev", position: "Manager", phone: "010-2345-6789", status: "퇴사" },
];

const EmployeePage = () => {
  const [employees, setEmployees] = useState(initialEmployeeList);
  const [open, setOpen] = useState(false);
  const [selectedEmployee, setSelectedEmployee] = useState<any | null>(null);

  // 등록/수정 모달 열기
  const handleOpen = (employee?: any) => {
    setSelectedEmployee(employee || null);
    setOpen(true);
  };

  // 모달 닫기
  const handleClose = () => {
    setOpen(false);
    setSelectedEmployee(null);
  };

  // 등록/수정 저장 시 (임시: 리스트에 추가/수정)
  const handleSave = (data: any) => {
    if (data.id) {
      setEmployees(prev =>
        prev.map(emp => (emp.id === data.id ? data : emp))
      );
    } else {
      setEmployees(prev => [
        ...prev,
        { ...data, id: prev.length + 1 }
      ]);
    }
    handleClose();
  };

  // 삭제
  const handleDelete = (id: number) => {
    setEmployees(prev => prev.filter(emp => emp.id !== id));
  };

  return (
    <Box>
      <Typography variant="h5" mb={2}>Employee List</Typography>
      <Button variant="contained" onClick={() => handleOpen()} sx={{ mb: 2 }}>
        Add Employee
      </Button>
      <Paper>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Name</TableCell>
              <TableCell>Department</TableCell>
              <TableCell>Position</TableCell>
              <TableCell>Phone</TableCell>
              <TableCell>Status</TableCell>
              <TableCell align="right">Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {employees.map(emp => (
              <TableRow key={emp.id}>
                <TableCell>{emp.name}</TableCell>
                <TableCell>{emp.dept}</TableCell>
                <TableCell>{emp.position}</TableCell>
                <TableCell>{emp.phone}</TableCell>
                <TableCell>{emp.status}</TableCell>
                <TableCell align="right">
                  <Button size="small" onClick={() => handleOpen(emp)}>Edit</Button>
                  <Button size="small" color="error" onClick={() => handleDelete(emp.id)}>
                    Delete
                  </Button>
                </TableCell>
              </TableRow>
            ))}
            {employees.length === 0 && (
              <TableRow>
                <TableCell colSpan={6} align="center">No employees</TableCell>
              </TableRow>
            )}
          </TableBody>
        </Table>
      </Paper>
      <Dialog open={open} onClose={handleClose} maxWidth="sm" fullWidth>
        <EmployeeFormDialog
          employee={selectedEmployee}
          onClose={handleClose}
          onSave={handleSave}
        />
      </Dialog>
    </Box>
  );
};

export default EmployeePage;

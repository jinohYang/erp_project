import React, { useState, useEffect } from "react";
import {
  Box,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  TextField,
  MenuItem,
} from "@mui/material";

const DEPARTMENT_LIST = ["HR", "Dev", "Sales", "Finance"];
const POSITION_LIST = ["Staff", "Assistant Manager", "Manager", "Director"];
const STATUS_LIST = ["재직", "퇴사"];

interface EmployeeFormDialogProps {
  employee?: any;
  onClose: () => void;
  onSave: (data: any) => void;
}

const EmployeeFormDialog = ({ employee, onClose, onSave }: EmployeeFormDialogProps) => {
  const [form, setForm] = useState({
    name: "",
    dept: "",
    position: "",
    phone: "",
    status: "재직",
  });

  useEffect(() => {
    if (employee) setForm(employee);
    else setForm({ name: "", dept: "", position: "", phone: "", status: "재직" });
  }, [employee]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = () => {
    onSave({ ...employee, ...form });
  };

  return (
    <>
      <DialogTitle>{employee ? "Edit Employee" : "Add Employee"}</DialogTitle>
      <DialogContent>
        <Box display="flex" flexDirection="column" gap={2} mt={1}>
          <TextField
            label="Name"
            name="name"
            value={form.name}
            onChange={handleChange}
            required
          />
          <TextField
            label="Department"
            name="dept"
            select
            value={form.dept}
            onChange={handleChange}
            required
          >
            {DEPARTMENT_LIST.map(dep => (
              <MenuItem key={dep} value={dep}>{dep}</MenuItem>
            ))}
          </TextField>
          <TextField
            label="Position"
            name="position"
            select
            value={form.position}
            onChange={handleChange}
            required
          >
            {POSITION_LIST.map(pos => (
              <MenuItem key={pos} value={pos}>{pos}</MenuItem>
            ))}
          </TextField>
          <TextField
            label="Phone"
            name="phone"
            value={form.phone}
            onChange={handleChange}
            required
          />
          <TextField
            label="Status"
            name="status"
            select
            value={form.status}
            onChange={handleChange}
            required
          >
            {STATUS_LIST.map(st => (
              <MenuItem key={st} value={st}>{st}</MenuItem>
            ))}
          </TextField>
        </Box>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button variant="contained" onClick={handleSubmit}>
          {employee ? "Save" : "Add"}
        </Button>
      </DialogActions>
    </>
  );
};

export default EmployeeFormDialog;

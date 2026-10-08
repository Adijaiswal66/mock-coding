import { Paper, Typography } from "@mui/material";

export default function EmployeesPage() {
  return (
    <>
      <Typography variant="h4" component="h1" fontWeight={700} gutterBottom>
        Employees
      </Typography>
      <Paper variant="outlined" sx={{ p: { xs: 3, sm: 5 }, mt: 3 }}>
        <Typography color="text.secondary">
          Employee management will be available here.
        </Typography>
      </Paper>
    </>
  );
}

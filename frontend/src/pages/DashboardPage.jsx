import { Paper, Typography } from "@mui/material";

export default function DashboardPage() {
  return (
    <>
      <Typography variant="h4" component="h1" fontWeight={700} gutterBottom>
        Dashboard
      </Typography>
      <Paper variant="outlined" sx={{ p: { xs: 3, sm: 5 }, mt: 3 }}>
        <Typography color="text.secondary">
          Welcome. Your workspace overview will appear here.
        </Typography>
      </Paper>
    </>
  );
}

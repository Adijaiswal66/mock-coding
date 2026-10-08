import { Paper, Typography } from "@mui/material";

export default function LoginPage() {
  return (
    <>
      <Typography variant="h4" component="h1" fontWeight={700} gutterBottom>
        Sign in
      </Typography>
      <Paper variant="outlined" sx={{ p: { xs: 3, sm: 5 }, mt: 3 }}>
        <Typography color="text.secondary">
          Sign-in functionality has not been implemented yet.
        </Typography>
      </Paper>
    </>
  );
}

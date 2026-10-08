import { Component } from "react";
import { Alert, Box, Button, Typography } from "@mui/material";

export default class ErrorBoundary extends Component {
  state = { hasError: false };

  static getDerivedStateFromError() {
    return { hasError: true };
  }

  componentDidCatch(error, errorInfo) {
    console.error("Application rendering error", error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      return (
        <Box
          sx={{
            minHeight: "100vh",
            display: "grid",
            placeItems: "center",
            p: 3,
          }}
        >
          <Box sx={{ maxWidth: 480, textAlign: "center" }}>
            <Typography variant="h4" component="h1" gutterBottom>
              Something went wrong
            </Typography>
            <Alert severity="error" sx={{ mb: 2, textAlign: "left" }}>
              The application encountered an unexpected error.
            </Alert>
            <Button
              variant="contained"
              onClick={() => window.location.reload()}
            >
              Reload application
            </Button>
          </Box>
        </Box>
      );
    }

    return this.props.children;
  }
}

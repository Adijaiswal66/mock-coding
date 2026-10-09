import { useEffect, useState } from "react";
import { getEmployees } from "../../../services/api/employeeService";
import { Button, Stack } from "@mui/material";

export default function EmployeesPage() {
  const [employees, setEmployees] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    getEmployees(page)
      .then((data) => {
        console.log(data);
        setEmployees(data.employeeResponseDto);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error("Error fetching employees:", error);
      })
      .finally(() => {
        setLoading(false);
      });
  }, [page]);
  return (
    <>
      {loading ? (
        "Loading..."
      ) : (
        <div>
          {employees.map((employee) => (
            <div key={employee.id}>
              {employee.firstName} {employee.lastName}
            </div>
          ))}
        </div>
      )}

      <Stack direction="row" spacing={2} alignItems="center">
        <Button
          variant="contained"
          disabled={page == 0}
          onClick={() => setPage((prev) => prev - 1)}
        >
          Previous
        </Button>
        {employees.map((employee) => {
          employee.firstName;
        })}
        <Button
          variant="contained"
          disabled={page >= totalPages - 1}
          onClick={() => setPage((prev) => prev + 1)}
        >
          Next
        </Button>
      </Stack>
    </>
  );
}

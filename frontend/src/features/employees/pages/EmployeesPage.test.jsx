import { render, screen, waitFor } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import "@testing-library/jest-dom";
import EmployeesPage from "./EmployeesPage";
import { getEmployees } from "../../../services/api/employeeService";

jest.mock("../../../services/api/employeeService");

const createResponse = (page) => ({
  employeeResponseDto: [
    {
      id: page + 1,
      firstName: page === 0 ? "Aditya" : "Rahul",
      lastName: "Jaiswal",
    },
  ],
  totalPages: 2,
});

beforeEach(() => {
  getEmployees.mockImplementation((page) =>
    Promise.resolve(createResponse(page)),
  );
});

afterEach(() => {
  jest.clearAllMocks();
});

test("disables Previous on the first page", async () => {
  render(<EmployeesPage />);

  expect(await screen.findByText("Aditya Jaiswal")).toBeInTheDocument();
  expect(screen.getByRole("button", { name: "Previous" })).toBeDisabled();
});

test("loads the next page when Next is clicked", async () => {
  const user = userEvent.setup();
  render(<EmployeesPage />);

  await screen.findByText("Aditya Jaiswal");
  await user.click(screen.getByRole("button", { name: "Next" }));

  expect(await screen.findByText("Rahul Jaiswal")).toBeInTheDocument();
  expect(getEmployees).toHaveBeenLastCalledWith(1);
});

test("loads the previous page when Previous is clicked", async () => {
  const user = userEvent.setup();
  render(<EmployeesPage />);

  await screen.findByText("Aditya Jaiswal");
  await user.click(screen.getByRole("button", { name: "Next" }));
  await screen.findByText("Rahul Jaiswal");

  await user.click(screen.getByRole("button", { name: "Previous" }));

  expect(await screen.findByText("Aditya Jaiswal")).toBeInTheDocument();
  expect(getEmployees).toHaveBeenLastCalledWith(0);
});

test("disables Next on the last page", async () => {
  const user = userEvent.setup();
  render(<EmployeesPage />);

  await screen.findByText("Aditya Jaiswal");
  await user.click(screen.getByRole("button", { name: "Next" }));
  await screen.findByText("Rahul Jaiswal");

  await waitFor(() => {
    expect(screen.getByRole("button", { name: "Next" })).toBeDisabled();
  });
});
export const getEmployees = async (page = 0, size = 20) => {
  const token = localStorage.getItem("accessToken");
  try {
    const response = await fetch(
      `/api/employees/all-emp?page=${page}&size=${size}`,
      {
        headers:{
          Authorization : `Bearer ${token}`,
        }
      }
    );

    if (!response.ok) {
      throw new Error("Failed to fetch employees");
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    throw error;
  }
};

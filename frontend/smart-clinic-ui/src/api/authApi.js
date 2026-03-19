import apiClient from "./apiClient";

export const signup = (data) => {
  return apiClient.post("/api/v1/clinics", data);
};

export const login = (data) => {
  return apiClient.post("/api/v1/auth/login", data);
};
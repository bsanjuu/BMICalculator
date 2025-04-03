FROM node:16 AS build

WORKDIR /app
COPY . /app
RUN npm install
RUN npm run build

# Production phase
FROM nginx:alpine

# Copy the build files to Nginx
COPY --from=build /app/build /usr/share/nginx/html

# Expose the port Nginx will use
EXPOSE 80

# Start the Nginx server
CMD ["nginx", "-g", "daemon off;"]

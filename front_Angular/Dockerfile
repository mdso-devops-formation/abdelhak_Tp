### STAGE 1 : BUILD ###
FROM node:19-alpine3.15 AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2 : RUN ### 
FROM nginx:1.17-alpine
COPY dist/crud/ /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/my-first-project /usr/share/nginx/html


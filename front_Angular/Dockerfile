### STAGE 1 : BUILD ###
FROM node AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2 : RUN ### 
FROM nginx:1.17-alpine
#COPY dist/crud/ /usr/share/nginx/html
COPY --from=build /app/dist/out/ /etc/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf

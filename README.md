# API Proxy Service

#### Java REST API proxy service designed to provide CORS compliance to web applications while querying EOS History API with subscription token.

### 1. Update target API base url and/or set auth token if using EOS Tribe History API in global.propoerties: 

token=#CHANGE-TOKEN#
apiserver=https://api.eostribe.io

### 2. Build project:

gradle clean build

### 3. Run API proxy application:

java -jar build/libs/api-proxy-1.0.0.jar

### 4. Configure access based on your needs.


### Contact 

Eugene eugene@eostribe.io 






# CINotification
1. run `gradle build jar` - build jar file with all dependencies
2. run `docker build --build-arg TOKEN_ID=<VALUE> --tag <name>:<version> .` - create docker image
3. run `docker run -e <name>:<version>` - run image in container
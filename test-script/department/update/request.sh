grpcurl \
    -plaintext \
    -proto ../../src/main/proto/department.proto \
    -d @ localhost:6565 \
    com.example.proto.department.DepartmentService.UpdateDepartment < update/request.json
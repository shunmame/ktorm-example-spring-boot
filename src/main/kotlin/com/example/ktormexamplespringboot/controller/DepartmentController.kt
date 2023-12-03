package com.example.ktormexamplespringboot.controller

import com.example.ktormexamplespringboot.domain.AddRequest
import com.example.ktormexamplespringboot.domain.UpdateRequest
import com.example.ktormexamplespringboot.proto.department.DepartmentOuterClass
import com.example.ktormexamplespringboot.proto.department.DepartmentServiceGrpc
import com.example.ktormexamplespringboot.service.DepartmentService
import com.google.protobuf.Empty
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class DepartmentController(
    private val departmentService: DepartmentService
) : DepartmentServiceGrpc.DepartmentServiceImplBase() {

    override fun addDepartment(
        request: DepartmentOuterClass.AddRequest,
        responseObserver: StreamObserver<Empty>
    ) {
        departmentService.addDepartment(
            AddRequest(
                name = request.name,
                location = request.location,
            )
        )

        responseObserver.onNext(Empty.getDefaultInstance())
        responseObserver.onCompleted()
    }

    override fun updateDepartment(
        request: DepartmentOuterClass.UpdateRequest,
        responseObserver: StreamObserver<Empty>
    ) {
        departmentService.updateDepartment(
            UpdateRequest(
                id = request.id,
                name = request.name,
                location = request.location,
            )
        )

        responseObserver.onNext(Empty.getDefaultInstance())
        responseObserver.onCompleted()
    }

    override fun getDepartments(
        request: DepartmentOuterClass.GetRequest,
        responseObserver: StreamObserver<DepartmentOuterClass.DepartmentResponses>
    ) {
        val departments = departmentService.getDepartments(request.id)

        responseObserver.onNext(
            DepartmentOuterClass.DepartmentResponses.newBuilder().addAllDepartments(
                departments.map {
                    DepartmentOuterClass.Department
                        .newBuilder()
                        .setId(it.id)
                        .setName(it.name)
                        .setLocation(it.location)
                        .build()
                }
            ).build()
        )
        responseObserver.onCompleted()
    }

    override fun deleteDepartment(
        request: DepartmentOuterClass.DeleteRequest,
        responseObserver: StreamObserver<Empty>
    ) {
        departmentService.deleteDepartment(request.id)

        responseObserver.onNext(Empty.getDefaultInstance())
        responseObserver.onCompleted()
    }
}
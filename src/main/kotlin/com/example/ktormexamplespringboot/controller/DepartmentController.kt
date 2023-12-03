package com.example.ktormexamplespringboot.controller

import com.example.ktormexamplespringboot.domain.AddRequest
import com.example.ktormexamplespringboot.domain.UpdateRequest
import com.example.ktormexamplespringboot.proto.department.DepartmentOuterClass
import com.example.ktormexamplespringboot.proto.department.DepartmentServiceGrpc
import com.example.ktormexamplespringboot.usecase.DepartmentUsecase
import com.google.protobuf.Empty
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class DepartmentController(
    private val departmentUsecase: DepartmentUsecase
) : DepartmentServiceGrpc.DepartmentServiceImplBase() {

    override fun addDepartment(
        request: DepartmentOuterClass.AddRequest,
        responseObserver: StreamObserver<Empty>
    ) {
        departmentUsecase.addDepartment(
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
        departmentUsecase.updateDepartment(
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
        val departments = departmentUsecase.getDepartments(request.id)

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
        departmentUsecase.deleteDepartment(request.id)

        responseObserver.onNext(Empty.getDefaultInstance())
        responseObserver.onCompleted()
    }
}
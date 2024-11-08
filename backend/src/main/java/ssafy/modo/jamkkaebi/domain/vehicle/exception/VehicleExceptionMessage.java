package ssafy.modo.jamkkaebi.domain.vehicle.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum VehicleExceptionMessage {
    DUPLICATED_VEHICLE_NUMBER(HttpStatus.CONFLICT.value(), "Already registered vehicle number");

    private final String message;
    private final int status;

    VehicleExceptionMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

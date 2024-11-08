package ssafy.modo.jamkkaebi.domain.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.modo.jamkkaebi.common.security.util.SecurityUtil;
import ssafy.modo.jamkkaebi.domain.manager.dto.response.ManageConnectResponseDto;
import ssafy.modo.jamkkaebi.domain.manager.exception.DriverConflictException;
import ssafy.modo.jamkkaebi.domain.member.entity.ManagerAndDriver;
import ssafy.modo.jamkkaebi.domain.member.entity.Member;
import ssafy.modo.jamkkaebi.domain.member.exception.DriverNotFoundException;
import ssafy.modo.jamkkaebi.domain.member.exception.ManagerNotFoundException;
import ssafy.modo.jamkkaebi.domain.member.repository.ManagerDriverRepository;
import ssafy.modo.jamkkaebi.domain.member.repository.MemberRepository;
import ssafy.modo.jamkkaebi.domain.member.service.MemberReadService;

@Service
@Transactional
@RequiredArgsConstructor
public class ManagerWriteService {

    private final ManagerDriverRepository managerDriverRepository;
    private final MemberRepository memberRepository;
    private final SecurityUtil securityUtil;
    private final MemberReadService memberReadService;

    public ManageConnectResponseDto connectDriver(Integer driverId) {

        if (memberReadService.isDriverConnected(driverId)) {
            throw new DriverConflictException();
        } else {
            Member manager = memberRepository.findByUsername(securityUtil.getCurrentUsername())
                    .orElseThrow(ManagerNotFoundException::new);
            Member driver = memberRepository.findById((long) driverId)
                    .orElseThrow(DriverNotFoundException::new);

            managerDriverRepository.save(ManagerAndDriver.builder()
                    .manager(manager)
                    .driver(driver)
                    .build());

            return ManageConnectResponseDto.builder()
                    .totalDrivers(managerDriverRepository.countByManagerId(manager.getId()))
                    .connectedDriverId(driverId)
                    .build();
        }
    }
}

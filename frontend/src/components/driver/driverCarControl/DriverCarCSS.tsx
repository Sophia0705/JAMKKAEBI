import styled from "styled-components";
import { GlassDiv } from "@/styles/driver/GlassmorphismStyle";

export const CarRightDiv = styled.div`
  width: 65%;
  min-width: 500px;
  padding: 0px 100px;
  /* background-color: gray; */
`;

export const CarRightMain = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  gap: 15px;
  /* background-color: white; */
`;

export const CarRightMenu = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
`;

export const CarMenuDiv = styled(GlassDiv)`
  width: 120px;
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 15px 17px;
  box-sizing: border-box;

  cursor: pointer;
  // 호버 스타일 추가
  &:hover {
    background: linear-gradient(
      135deg,
      rgba(255, 255, 255, 0.5) 0%,
      rgba(255, 255, 255, 0.2) 100%
    );
    transform: scale(1.05); // 살짝 확대되는 효과
    transition:
      background 0.3s ease,
      transform 0.3s ease;
  }
`;

export const CarMenuDivBody = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 8px;
`;

export const CarRightBody = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
`;
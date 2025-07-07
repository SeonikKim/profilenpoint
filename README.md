Profilenpoint 서비스 Docker 배포 안내

Prerequisites

Docker Desktop 설치 및 실행 (Windows/Mac/Linux)

기본적인 Docker 사용 권한(관리자 또는 권한 있는 사용자)

# Git 저장소 다운로드

1. ZIP 파일을 내려받은 경우
2. 압축 해제 후 해당 폴더로 이동
unzip profilenpoint.zip -d profilenpoint
cd profilenpoint

3. 또는 Git CLI 사용 시
git clone https://github.com/<your-username>/profilenpoint.git
cd profilenpoint

# Docker Compose 실행

프로젝트 루트(docker-compose.yml 파일이 있는 디렉터리)로 이동

Windows 예시) cd E:/proj/profilenpoint

macOS/Linux 예시) cd ~/proj/profilenpoint

백그라운드에서 컨테이너 빌드 및 실행

docker-compose up --build -d

# 서비스 확인

MySQL

호스트: localhost:15306

데이터베이스: proj1

사용자명: seonik, 비밀번호: seonikjjang

Spring Boot 애플리케이션

접속 URL: http://localhost:8081

# 주요 명령어

docker-compose ps : 실행 중인 컨테이너 상태 확인

docker-compose logs -f app : 앱 컨테이너 로그 실시간 확인

docker-compose down : 모든 컨테이너 중지 및 네트워크/볼륨 정리

docker-compose up --build -d : 컨테이너 재빌드 및 재실행

docker exec -it mysql mysql -u seonik -p : MySQL 콘솔 접속 (비밀번호 입력 후)

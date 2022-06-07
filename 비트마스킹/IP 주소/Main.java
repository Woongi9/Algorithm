import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //IP주소 저장 배열
        int[] netIp = new int[n];

        // 초기값
        int netAddress = 0;
        int netMask = 0;

        //IP주소 인트 형변환 및 저장
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(),".");
            int temp = 0;
            for(int j = 0; j < 4; j++){
                int m = Integer.parseInt(st.nextToken());
                // 기존꺼 8칸 밀기
                temp <<= 8;
                // 현재꺼 더하기
                temp += m;
            }
            // 구한 ip 저장
            netIp[i] = temp;
        }


        // 넷마스크 구하기
        for(int i = 31; i >= 0; i--){
            int bit = 1<<i;
            boolean check = false;

            for(int j = 1; j < n; j++){
                if((netIp[0] & bit) != (netIp[j] & bit)){
                    check = true;
                    break;
                }
            }

            if(check){
                break;
            }else{
                netMask |= bit;
            }
        }
        
        // // 넷 주소 구하기
        netAddress = netIp[0]&netMask;

        //인트 - 스트링 형변환
        String address = "";
        String mask = "";

        // 각 파트 별 숫자 찾기 변수
        int check = (1<<8)-1; // 다켜진 비트집합

        int k = 3; //제일 위의 파트부터 구하면서 내려올것.
        while(true){
            int anum = netAddress>>(8*k) & check;
            int mnum = netMask>>(8*k) & check;

            address += String.valueOf(anum);
            mask += String.valueOf(mnum);

            netAddress &= ((1<<(8*k))-1); //8*k번째 원소 왼쪽은 다 0으로 만들어주는 식
            netMask &= ((1<<(8*k))-1);
            k--;

            if(k == -1){
                break;
            }
            address += ".";
            mask += ".";
        }

        System.out.println(address);
        System.out.println(mask);
    }
}

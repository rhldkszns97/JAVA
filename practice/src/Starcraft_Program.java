public class Starcraft_Program {
    public static void main(String[] args) {
        Starcraft_unit me = new Starcraft_unit();
        Starcraft_unit other = new Starcraft_unit();
        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");


        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
        String[] myUnitString = me.user_create();
        me.user_print(myUnitString);
        int[] myUnit = me.user_info_int(myUnitString);


        System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
        String[] otherUnitString = other.user_create();
        other.user_print(otherUnitString);
        int[] otherUnit = other.user_info_int(otherUnitString);

        me.attack(myUnitString[0],myUnit,otherUnit);

    }
}
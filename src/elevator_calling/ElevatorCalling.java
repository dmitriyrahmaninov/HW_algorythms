package elevator_calling;

public class ElevatorCalling {
    public static void main(String[] args) {
        int enterStoreys = 0;
        int storeysA = 2;
        int storeysB = 3;
        int buildingStoreys = 5;
        minCountStoreys(enterStoreys, storeysA, storeysB, buildingStoreys);

    }

    private static void minCountStoreys(int enterStoreys, int storeysA, int storeysB, int buildingStoreys) {

        while (storeysA <= buildingStoreys || storeysB <= buildingStoreys) {

            if (enterStoreys == storeysA) {
                System.out.println("Elevator A will be arrive");
                return;
            } else if (enterStoreys == storeysB) {
                System.out.println("Elevator B will be arrive");
                return;
            } else if (storeysA == storeysB) {
                System.out.println("Elevator A and elevator B will arrive together");
                return;
            } else {

                int movementElevatorA = Math.abs(enterStoreys - storeysA);
                int movementElevatorB = Math.abs(enterStoreys - storeysB);
                int minCountStoreys = Math.min(movementElevatorA, movementElevatorB);

                if (minCountStoreys == movementElevatorA) {
                    System.out.println("Elevator A will arrive");
                } else {
                    System.out.println("Elevator B will arrive");
                }
                return;
            }
        }
    }
}



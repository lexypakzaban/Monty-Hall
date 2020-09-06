public class MontyRunner {
    public static void main(String[] args) {

        int stayed = 0;
        int switched = 0;
        int stayingWins = 0;
        int switchingWins = 0;

        for (int j = 0; j < 10000; j++){
//SECRET DOOR WITH CAR
            int secretDoor = (int) (Math.random() * 3) + 1;
            //System.out.println("The car is behind door #" + secretDoor + ". Shh! Don't tell anybody!" );
            //System.out.println("Monty says, \"Is the car behind door 1, 2, or 3?\"");

//PICKED DOOR
            int pickedDoor = (int) (Math.random() * 3) + 1;
            //System.out.println("The player picks door #" + pickedDoor);

//GOAT DOOR
            int goatDoor = 0;
            for (int doorNumber = 1; doorNumber < 4; doorNumber++) {
                if (doorNumber != secretDoor && doorNumber != pickedDoor) {
                    goatDoor = doorNumber;
                }
            }

            //System.out.println("Monty reveals door #" + goatDoor + " has a goat.");

//PLAYER CHOOSES TO STAY OR SWITCH
            int flipCoin = (int) (Math.random() * 2);
            int switchedDoor = 0;
            if (flipCoin == 0) {
                //System.out.println("The player chooses to stay with door #" + pickedDoor);
                stayed++;
            }
            else {
                for (int i = 1; i < 4; i++) {
                    if (i != pickedDoor && i != goatDoor) {
                        switchedDoor = i;
                    }
                }
                //System.out.println("The player chooses to switch to door #" + switchedDoor);
                switched++;
            }

//WIN OR LOSE
            if (switchedDoor == secretDoor && flipCoin == 1){
                //System.out.println("The player wins a car!");
                switchingWins++;
            }

            else if (pickedDoor == secretDoor && flipCoin == 0){
                //System.out.println("The player wins a car!");
                stayingWins++;
            }

            else {
                //System.out.println("The player loses.");
            }


        }

        System.out.println("Player stayed " + stayed + " times");
        System.out.println("Player switched " + switched + " times");
        System.out.println("\"Staying\" won " + stayingWins + " times");
        System.out.println("\"Switching\" won " + switchingWins + " times");
        System.out.println("Staying wins " + ((double)stayingWins/(stayed + switched)) * 100 + "% of the time");
        System.out.println("Switching wins " + ((double)switchingWins/(stayed + switched)) * 100 + "% of the time");

    }
}

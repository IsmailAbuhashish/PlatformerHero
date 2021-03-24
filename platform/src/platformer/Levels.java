package platformer;

public class Levels {
	int state = 3;
	public int[][][] testBench(){
		int[][][] map = new int[100][100][state];
		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) {
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) {
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) {
			for(int y = 80; y < 100;y++) {
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}

		for(int x = 0; x < 34;x++) {
			for(int y = 35; y < 37;y++) {
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}

		for(int x = 0; x < 100;x++) {
			for(int y = 35; y < 37;y++) {
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}
		for(int i=25; i <= 29;i++ ) {
			map[i][32][0]=1;
			map[i][32][1]=1;
		}

		map[33][33][0] = 2;
		map[33][33][1] = 2;
		return map;
	}
	public int[][][] emptyLevel(){
		int[][][] map = new int[100][100][state];
		return map;
	}
	public int[][][] firstLevel(){
		//						 y 	   x
		int[][][] map = new int[100][100][state];
		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) {// creates the ceiling
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) { //left most wall
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) { //right most wall
			for(int y = 80; y < 100;y++) {
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) {
			for(int y = 37; y < 40;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 28;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 36; x < 80;x++) {// death platform
			map[x][36][0] = 2;
			map[x][36][1] = 2;
		}
		for(int x = 33; x < 38 ;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}


		for(int i=25; i <= 28;i++ ) {// platform
			map[i][34][0]=1;
			map[i][34][1]=1;
		}

		for(int i=32; i <= 34;i++ ) {// platform
			//			     	x	y  type     position of block
			map[i][30][0]=1; // =0 means not visible  & =1 means visible
			map[i][30][1]=1; // =0 means go through & =1 means not go through
		}
		for(int i=45; i <= 47;i++ ) {// platform
			//			     	x	y  type     position of block
			map[i][28][0]=1; // =0 means not visible  & =1 means visible
			map[i][28][1]=1; // =0 means go through & =1 means not go through

		}
		for(int i=56; i <= 57;i++ ) {// platform
			//			     	x	y  type     position of block
			map[i][24][0]=1; // =0 means not visible  & =1 means visible
			map[i][24][1]=1; // =0 means go through & =1 means not go through

		}
		for(int i=65; i <= 67;i++ ) {// platform
			//			     	x	y  type     position of block
			map[i][30][0]=1; // =0 means not visible  & =1 means visible
			map[i][30][1]=1; // =0 means go through & =1 means not go through

		}
		for(int i=75; i <= 80;i++ ) {// platform
			//			     	x	y  type     position of block
			map[i][27][0]=1; // =0 means not visible  & =1 means visible
			map[i][27][1]=1; // =0 means go through & =1 means not go through

		}

		for(int i = 20;i< 26;i++)// winning platform
			map[77][i][1]=3;
		return map;
	}
	public int[][][] secondLevel(){
		//						 y 	   x
		int[][][] map = new int[100][100][state];
		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) {// creates the ceiling
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) { //left most wall
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) { //right most wall
			for(int y = 80; y < 100;y++) {
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) {
			for(int y = 37; y < 40;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 28;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 2; // =0 background texture  & = 1 means block texture  & = 2 lava texture
				map[y][x][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
			}
		}
		for(int x = 20; x < 80;x++) {// death platform
			map[x][36][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][36][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=20; i <= 21;i++ ) {// platform
			// x	y  type     position of block
			map[i][30][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][30][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block

		}
		for(int i=30; i <= 31;i++ ) {// platform
			// x	y  type     position of block
			map[i][26][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][26][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block

		}

		for(int i=65; i <= 67;i++ ) {// platform
			// x	y  type     position of block
			map[i][30][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][30][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block

		}
		for(int i=36; i <= 37;i++ ) {// platform
			// x	y  type     position of block
			map[i][33][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][33][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block

		}
		// platform
		//  x	y  type     position of block
		map[46][29][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
		map[46][29][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block


		for(int i=59; i <= 60;i++ ) {// platform
			// x	y  type     position of block
			map[i][25][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][25][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block

		}


		for(int i = 79;i< 80;i++) {// winning platform
			map[i][24][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][24][1]=3; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		return map;
	}
	public int[][][] thirdLevel(){
		//						 y 	   x
		int[][][] map = new int[100][100][state];
		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) {// creates the ceiling
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) { //left most wall
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) { //right most wall
			for(int y = 80; y < 100;y++) {
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 25;x++) {
			for(int y = 37; y < 40;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}
		for(int x = 30; x < 100;x++) {
			for(int y = 37; y < 40;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}
		for(int x = 20; x < 100;x++) {
			for(int y = 85; y < 90;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 20;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 2; // =0 background texture  & = 1 means block texture  & = 2 lava texture
				map[y][x][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
			}
		}
		for(int x = 23; x < 35;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 2; // =0 background texture  & = 1 means block texture  & = 2 lava texture
				map[y][x][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
			}
		}
		for(int x = 20; x < 25;x++) {// death platform
			map[x][36][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][36][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}
		for(int x = 30; x < 80;x++) {// death platform
			map[x][36][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][36][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}
		
		for(int x = 20; x < 80;x++) {// death platform
			map[x][85][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][85][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}

		for(int i=20; i <= 21;i++ ) {// platform
			//  x	y  type     position of block
			map[i][24][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][24][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=30; i <= 31;i++ ) {// platform
			//  x	y  type     position of block
			map[i][27][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][27][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=39; i <= 40;i++ ) {// platform
			//  x	y  type     position of block
			map[i][24][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][24][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=50; i <= 51;i++ ) {// platform
			//  x	y  type     position of block
			map[i][32][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][32][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=64; i <= 65;i++ ) {// platform
			//  x	y  type     position of block
			map[i][28][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][28][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=79; i <= 80;i++ ) {// platform
			//  x	y  type     position of block
			map[i][33][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][33][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i = 26;i< 30;i++) {// winning platform
			map[i][80][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][80][1]=3; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		} 
		return map;
	}
	public int[][][] fourthLevel(){
		//						 y 	   x
		int[][][] map = new int[100][100][state];
		for(int x = 0; x < 100;x++) {
			for(int y = 0; y < 20;y++) {// creates the ceiling
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 100;x++) {//left most wall
			for(int y = 0; y < 20;y++) { // thickness
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 100;x++) { //right most wall
			for(int y = 80; y < 100;y++) { // thickness
				map[y][x][0] = 1;
				map[y][x][1] = 1;
			}
		}
		for(int x = 0; x < 60;x++) {
			for(int y = 37; y < 40;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}
		for(int x = 70; x < 100;x++) {
			for(int y = 37; y < 40;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}
		for(int x = 20; x < 100;x++) {
			for(int y = 85; y < 90;y++) {// runway block depth
				map[x][y][0] = 1;
				map[x][y][1] = 1;
			}
		}

		for(int x = 0; x < 25;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 2; // =0 background texture  & = 1 means block texture  & = 2 lava texture
				map[y][x][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
			}
		}
		for(int x = 29; x < 35;x++) {// height of the divider
			for(int y = 35; y < 36;y++) {// thickness of the wall divider
				map[y][x][0] = 2; // =0 background texture  & = 1 means block texture  & = 2 lava texture
				map[y][x][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
			}
		}
		for(int x = 20; x < 60;x++) {// death platform
			map[x][36][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][36][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}
		for(int x = 70; x < 80;x++) {// death platform
			map[x][36][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][36][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}
		
		for(int x = 20; x < 80;x++) {// death platform
			map[x][85][0] = 2;  // =0 background texture  & = 1 means block texture  & = 2 lava texture
			map[x][85][1] = 2; // = 0 transparent block & =1 solid block & = 2 death block & = 3 winning block
		}

		for(int i=20; i <= 21;i++ ) {// platform
			//  x	y  type     position of block
			map[i][24][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][24][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=28; i <= 29;i++ ) {// platform
			//  x	y  type     position of block
			map[i][30][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][30][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=41; i <= 42;i++ ) {// platform
			//  x	y  type     position of block
			map[i][27][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][27][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=52; i <= 53;i++ ) {// platform
			//  x	y  type     position of block
			map[i][26][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][26][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=65; i <= 67;i++ ) {// platform
			//  x	y  type     position of block
			map[i][70][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][70][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=49; i <= 50;i++ ) {// platform
			//  x	y  type     position of block
			map[i][67][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][67][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		for(int i=42; i <= 43;i++ ) {// platform
			//  x	y  type     position of block
			map[i][73][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][73][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		
		for(int i=31; i <= 32;i++ ) {// platform
			//  x	y  type     position of block
			map[i][65][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][65][1]=1; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		}
		
		for(int i = 22;i< 23;i++) {// winning platform
			map[i][80][0]=1; // = 0 background texture  & = 1 means block texture  & = 2 lava texture
			map[i][80][1]=3; // = 0 transparent block & = 1 solid block & = 2 death block & = 3 winning block
		} 
		return map;
	}
}
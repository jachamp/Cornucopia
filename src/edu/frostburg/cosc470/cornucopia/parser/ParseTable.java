package edu.frostburg.cosc470.cornucopia.parser;

/**
 * Matrix representation of this compiler's parse table.
 * 
 * @author James Champ
 * @version	0.8, May 16, 2016
 */
public class ParseTable 
{
	protected final static int S1 = 1;
	protected final static int S2 = 2;
	protected final static int S6 = 6;
	protected final static int S7 = 7;
	protected final static int S8 = 8;
	protected final static int S9 = 9;
	protected final static int S10 = 10;
	protected final static int S12 = 12;
	protected final static int S13 = 13;
	protected final static int S14 = 14;
	protected final static int S15 = 15;
	protected final static int S17 = 17;
	protected final static int S18 = 18;
	protected final static int S20 = 20;
	protected final static int S21 = 21;
	protected final static int S22 = 22;
	protected final static int S23 = 23;
	protected final static int S29 = 29;
	protected final static int S30 = 30;
	protected final static int S31 = 31;
	protected final static int S32 = 32;
	protected final static int S33 = 33;
	protected final static int S34 = 34;
	protected final static int S35 = 35;
	protected final static int S36 = 36;
	protected final static int S38 = 38;
	protected final static int S39 = 39;
	protected final static int S40 = 40;
	protected final static int S41 = 41;
	protected final static int S42 = 42;
	protected final static int S48 = 48;
	protected final static int S49 = 49;
	protected final static int S52 = 52;
	protected final static int S53 = 53;
	protected final static int S55 = 55;
	protected final static int S56 = 56;
	protected final static int S57 = 57;
	protected final static int S58 = 58;
	protected final static int S59 = 59;
	protected final static int S60 = 60;
	protected final static int S61 = 61;
	protected final static int S62 = 62;
	protected final static int S63 = 63;
	protected final static int S66 = 66;
	protected final static int S67 = 67;
	protected final static int S68 = 68;
	protected final static int S70 = 70;
	protected final static int S71 = 71;
	protected final static int S72 = 72;
	protected final static int S73 = 73;
	protected final static int S74 = 74;

	protected final static int R1 = 100;
	protected final static int R2 = 101;
	protected final static int R3 = 102;
	protected final static int R4 = 103;
	protected final static int R5 = 104;
	protected final static int R6 = 105;
	protected final static int R7 = 106;
	protected final static int R8 = 107;
	protected final static int R9 = 108;
	protected final static int R10 = 109;
	protected final static int R11 = 110;
	protected final static int R12 = 111;
	protected final static int R13 = 112;
	protected final static int R14 = 113;
	protected final static int R15 = 114;
	protected final static int R16 = 115;
	protected final static int R17 = 116;
	protected final static int R18 = 117;
	protected final static int R19 = 118;
	protected final static int R20 = 119;
	protected final static int R21 = 120;
	protected final static int R22 = 121;
	protected final static int R23 = 122;
	protected final static int R24 = 123;
	protected final static int R25 = 124;
	protected final static int R26 = 125;
	protected final static int R27 = 126;
	protected final static int R28 = 127;
	protected final static int R29 = 128;
	protected final static int R30 = 129;
	protected final static int R31 = 130;
	protected final static int R32 = 131;
	protected final static int R33 = 132;
	protected final static int R34 = 133;
	protected final static int R35 = 134;
	protected final static int R36 = 135;
	protected final static int R37 = 136;
	protected final static int R38 = 137;
	protected final static int R39 = 138;
	protected final static int R40 = 139;
	protected final static int R41 = 140;
	protected final static int R42 = 141;

	protected final static int ERR = 900;

	protected final static int ACC = 200;

	/**
	 * Parse table for Cornucopia compiler.
	 */
	protected final static int[][] PARSE_TABLE = { // Actions:																																										      Gotos:
													//  0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33   34   35   36   37   38   39   40   41   42   43   44   45   46   47   48   49   50   51   52   
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  S1,  S2, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,   3,   4, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2,  R2, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3,  R3, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  S6, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR,  S7, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR,  S8, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR,  S9, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R6,  R6, S10,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6, ERR, ERR,  11, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4,  R4, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, S12, ERR, ERR, ERR, ERR, ERR, S13, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, S14, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S15, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8,  R8, ERR, ERR, ERR,  16, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5,  R5, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, S17, ERR, ERR, ERR, ERR, ERR, S18, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  19, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S20, ERR, ERR, S17, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S21, S22, S23, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  24, ERR,  25,  26,  27, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R6,  R6, S10,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6,  R6, ERR, ERR,  28, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, S29, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S30, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, S31, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, S32, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, S33, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, R15, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, S34, ERR, ERR, ERR, ERR, ERR, ERR, S35, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, R12, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, R14, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S13, ERR, S36, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ACC, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S38, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S39, S40, S41, S42, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  44,  43,  45, ERR,  46, ERR,  47, ERR },
													{ ERR, ERR, S48, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S49, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S38, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S39, S40, S41, S42, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  50, ERR,  45, ERR,  46, ERR,  47, ERR },
													{ R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, R11, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S20, ERR, ERR, S17, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S21, S22, S23, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  24, ERR, ERR,  51,  27, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S52, S53, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  54, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1,  R1, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, R27, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, R28, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, R29, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, R30, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S55, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, R19, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, R20, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, R21, S56, S57, S58, S59, S60, S61, S62, S63, R21, R21, R21, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  64, ERR,  65, ERR, ERR },
													{ R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, R23, S66, S67, S68, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, 69 },
													{ R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, R25, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, S70, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, S71, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, S72, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, R13, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9,  R9, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, R10, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S73, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S74, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, R32, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, R33, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, R34, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, R35, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, R36, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, R37, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, R38, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, R39, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S38, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S39, S40, S41, S42, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  75, ERR,  46, ERR,  47, ERR },
													{ ERR, ERR, S38, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S39, S40, S41, S42, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  76, ERR,  47, ERR },
													{ R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, R40, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, R41, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, R42, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S38, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S39, S40, S41, S42, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  77, ERR },
													{ R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, R16, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, R17, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ ERR, ERR, S20, ERR, ERR, S17, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, S21, S22, S23, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  24, ERR, ERR,  78,  27, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7,  R7, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, R31, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, R22, S62, S63, R22, R22, R22, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  65, ERR, ERR },
													{ R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, R24, S66, S67, S68, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR,  69 },
													{ R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, R26, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR },
													{ R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, R18, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR }
	};
}

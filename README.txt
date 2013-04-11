/**********************************************************************                                                 
 *  Burrows-Wheeler data compression.
**********************************************************************/

Name: PF (Rick) Kleinhans - 16959787    

/**********************************************************************
 *  List in table format which input files you used to test your program.
 *  Fill in columns for how long your program takes to compress and
 *  decompress these instances (by applying BurrowsWheeler, MoveToFront,
 *  and Huffman in succession). Also, fill in the third column for
 *   the compression ratio.
 **********************************************************************/

File     Encoding Time    Decoding time      Compression ratio
------------------------------------------------------------------------



/**********************************************************************
 *  Compare the results of your program (compression ratio and running
 *  time) on mobydick.txt to that of the most popular Windows
 *  compression program (pkzip) or the most popular Unix/Mac one (gzip).
 *  If you don't have pkzip, use 7zip and compress using zip format.
 **********************************************************************/


/**********************************************************************
 *  Give the order of growth of the running time of each of the 4
 *  methods below as a function of the input size N and the alphabet size R
 *  both in practice (on typical English text inputs) and in theory
 *  (in the worst case), e.g., N, N log N, N^2, R N.
 *
 *  Include the time for sorting in the Burrows-Wheeler encoder.
 **********************************************************************/

                             in practice           in theory
------------------------------------------------------------------------
BurrowsWheeler encode()
BurrowsWheeler decode()
MoveToFront encode()
MoveToFront decode()



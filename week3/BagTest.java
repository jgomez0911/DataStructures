
public class BagTest{

	public static void main( String[] args ) {
		IntArrayBag bagA1 = new IntArrayBag();
		IntArrayBag bagA2 = new IntArrayBag();

		IntLinkedBag bagL1 = new IntLinkedBag();
		IntLinkedBag bagL2 = new IntLinkedBag();

		for ( int j = 1; j <= 10; j++ ) {
			bagA1.add( j );
			bagL1.add( j );
		}

		for ( int j = 10; j >= 1; j-- ) {
			bagA2.add( j );
			bagL2.add( j );
		}

		System.out.println( "bagA1 and bagA2 have the same elements:  " + bagA1.sameAs( bagA2 ) );
		System.out.println( "bagL1 and bagL2 have the same elements:  " + bagL1.sameAs( bagL2 ) );

		int oldVal = 6;
		Integer newVal = 7;
		bagA2.replace( oldVal, newVal );
		bagL2.replace( oldVal, newVal );

		System.out.println( "bagA1 and bagA2 have the same elements:  " + bagA1.sameAs( bagA2 ) );
		System.out.println( "bagL1 and bagL2 have the same elements:  " + bagL1.sameAs( bagL2 ) );
	}
}
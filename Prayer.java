public class Prayer extends Visitor {

	public Prayer(){
		super(null, null, null);
	}

	@Override
	public void visit() {
        System.out.println("Prayer class");
    }
}

package myworldsim;

public class MachineGun extends Gun
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int				machineGunMount;
	
	/*
	 * Class Constants
	 * 
	 */
	
	// Defaults for a hand gun
	
	private final int		BIPOD_MOUNT						= 1;
	private final int		TRIPOD_MOUNT					= 2;
	private final int		BOLTED_MOUNT					= 3;
	private final int		SURFACE_MOUNT					= 4;
	
	private final int		DEFAULT_MACHINE_GUN_MOUNT		= BIPOD_MOUNT;
	private final double	DEFAULT_MACHINE_GUN_CALIBER		= 30;
	private final int		DEFAULT_MACHINE_GUN_WEIGHT		= 30;
	private final int		DEFAULT_MACHINE_GUN_AMMO		= 250;
	private final int		DEFAULT_MACHINE_GUN_RPM			= 600;
	
	/*
	 * Constructor Method
	 * 
	 */
	
	public MachineGun()
	{
		super();
		
		
	}
}

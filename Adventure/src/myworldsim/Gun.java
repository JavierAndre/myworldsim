package myworldsim;

public class Gun extends Weapon
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private boolean				gunAutomaticSetting;
	private	int					gunAmmo;							// Number of rounds in magazine
	private double				gunCaliber;
	private int					gunRecoil;
	private boolean				gunScope;
	private int					gunRPM;								// Only in automatic setting
	
	/*
	 * Class Constants
	 * 
	 */
	
	// Default for a hand gun
	
	private final int			DEFAULT_GUN_AMMO 			= 12;
	private	final double		DEFAULT_GUN_CALIBER 		= 45;
	
	private final int			DEFAULT_HAND_GUN_RECOIL		= 1;
	private final int			DEFAULT_RIFLE_RECOIL		= 2;
	private final int			DEFAULT_SHUTGUN_RECOIL		= 3;
	private final int			DEFAULT_MACHINE_GUN_RECOIL	= 4;
	private final int			DEFAULT_CANNON_RECOIL		= 5;
	
	public static final int		DEFAULT_DAMAGE				= 25;	// Percent of health
	public static final double	DEFAULT_WEIGHT				= 1;	// In pounds
	public static final int		DEFAULT_ACCURACY			= 50;	// In yards;
	public static final int		DEFAULT_RANGE				= 100;	// In yards;
	public static final int		DEFAULT_RPM					= 60;	// One round at a time, approx. 1 round per second	
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Gun()
	{
		super(DEFAULT_DAMAGE, DEFAULT_WEIGHT, DEFAULT_ACCURACY, DEFAULT_RANGE, DEFAULT_LIGHT_WEIGHT_MOBILITY);
		
		gunAutomaticSetting	= false;
		gunAmmo 			= DEFAULT_GUN_AMMO;
		gunCaliber			= DEFAULT_GUN_CALIBER;
		gunRecoil			= DEFAULT_HAND_GUN_RECOIL;
		gunScope			= false;
		gunRPM				= DEFAULT_RPM;
	}
	
	public Gun(double caliber, double weight, int ammo, int RPM, boolean automatic)
	{
		super(DEFAULT_DAMAGE, DEFAULT_WEIGHT, DEFAULT_ACCURACY, DEFAULT_RANGE, DEFAULT_LIGHT_WEIGHT_MOBILITY);
		
		gunAutomaticSetting	= automatic;
		gunAmmo 			= ammo;
		gunCaliber			= caliber;
		gunRecoil			= DEFAULT_HAND_GUN_RECOIL;
		gunScope			= false;
		gunRPM				= RPM;
	}
	
	public Gun(int damage, double weight, int accuracy, int range, int mobility, boolean automatic, int ammo, int caliber, int recoil, boolean scope, int RPM)
	{
		super(damage, weight, accuracy, range, mobility);
		
		gunAutomaticSetting = automatic;
		gunAmmo				= ammo;
		gunCaliber			= caliber;
		gunRecoil			= recoil;
		gunScope			= scope;
		gunRPM				= RPM;
	}
}

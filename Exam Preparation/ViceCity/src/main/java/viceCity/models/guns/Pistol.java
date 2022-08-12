package viceCity.models.guns;

public class Pistol extends BaseGun {

    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() <= 0 && this.canFire()) {
            int bulletsForReload = Math.min(BULLETS_PER_BARREL, this.getTotalBullets());
            this.setTotalBullets(this.getTotalBullets() - bulletsForReload);
            this.setBulletsPerBarrel(bulletsForReload);
        }
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - 1);
        return 1;
    }
}

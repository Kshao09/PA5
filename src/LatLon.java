public class LatLon {
    double longitude, latitude;

    public LatLon(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "LatLon{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

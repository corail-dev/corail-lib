package net.corail.nms;

public class Vector3 {

    private int x;
    private int y;
    private int z;

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(int x, int y, int z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void add(Vector3 vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
    }

    public void sub(int x, int y, int z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
    }

    public void sub(Vector3 vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
    }

    public void mul(int x, int y, int z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
    }

    public void mul(Vector3 vec) {
        this.x *= vec.x;
        this.y *= vec.y;
        this.z *= vec.z;
    }

    public void div(int x, int y, int z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
    }

    public void div(Vector3 vec) {
        this.x /= vec.x;
        this.y /= vec.y;
        this.z /= vec.z;
    }

    public void mod(int x, int y, int z) {
        this.x %= x;
        this.y %= y;
        this.z %= z;
    }

    public void mod(Vector3 vec) {
        this.x %= vec.x;
        this.y %= vec.y;
        this.z %= vec.z;
    }

    public void abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public void min(int x, int y, int z) {
        this.x = Math.min(this.x, x);
        this.y = Math.min(this.y, y);
        this.z = Math.min(this.z, z);
    }

    public void min(Vector3 vec) {
        this.x = Math.min(this.x, vec.x);
        this.y = Math.min(this.y, vec.y);
        this.z = Math.min(this.z, vec.z);
    }

    public void max(int x, int y, int z) {
        this.x = Math.max(this.x, x);
        this.y = Math.max(this.y, y);
        this.z = Math.max(this.z, z);
    }

    public void max(Vector3 vec) {
        this.x = Math.max(this.x, vec.x);
        this.y = Math.max(this.y, vec.y);
        this.z = Math.max(this.z, vec.z);
    }

}

package pt.ipb.esact.compgraf.engine.movement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.tools.math.GlMath;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.vecmath.Vector3f;

public class Mover {

    private static final Logger logger = LoggerFactory.getLogger(Mover.class);

    private float maxLinearSpeed = 3.0f;

    private float maxAngularSpeed = 10.0f;

    private float linearAcceleration = 2.0f;

    private float angularAcceleration = 20.0f;

    private Vector3f position = Vectors.zero();

    private Vector3f forward = Vectors.forward();

    private Vector3f velocity = Vectors.zero();

    private Vector3f acceleration = Vectors.zero();

    private float orientation = 0.0f;

    private boolean needsUpdate;

    private boolean moveForward = false;

    private boolean moveBackward = false;

    private boolean strafeLeft = false;

    private boolean strafeRight = false;

    private boolean stop = false;

    public Mover() {
        needsUpdate = true;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(float x, float y, float z) {
        this.position = new Vector3f(x, y, z);
    }

    public Vector3f getVelocity() {
        return velocity;
    }

    public Vector3f strafeLeft(float fraction) {
        Vector3f left = GlMath.rotate(90.0f, GlMath.VECTOR_UP, forward);
        velocity.set(0, 0, 0);
        velocity.add(left);
        velocity.scale(fraction * maxLinearSpeed);
        position.add(velocity);
        needsUpdate = velocity.lengthSquared() > 0;
        return position;
    }

    public Vector3f strafeRight(float fraction) {
        Vector3f right = GlMath.rotate(-90.0f, GlMath.VECTOR_UP, forward);
        velocity.set(0, 0, 0);
        velocity.add(right);
        velocity.scale(fraction * maxLinearSpeed);
        position.add(velocity);
        needsUpdate = velocity.lengthSquared() > 0;
        return position;
    }

    public void forward() {
        moveForward = true;
        stop = false;
    }

    public void backward() {
        moveBackward = true;
        stop = false;
    }

    public void stop() {
        stop = true;
        moveForward = false;
        moveBackward = false;
    }

    public Vector3f update(float timeElapsed) {
        Vector3f increase = new Vector3f();
        if (moveForward) {
            increase.add(forward);
            moveBackward = false;
        }

        if (moveBackward) {
            increase.add(forward);
            increase.negate();
            moveBackward = false;
        }

        increase.scale(timeElapsed * linearAcceleration);

        velocity.add(increase);
        if (velocity.lengthSquared() == 0)
            return position;

        if (velocity.lengthSquared() > maxLinearSpeed * maxLinearSpeed) {
            velocity.normalize();
            velocity.scale(maxLinearSpeed);
        }

        if (stop) {
            Vector3f d = new Vector3f(forward);
            d.scale(linearAcceleration * timeElapsed);
            velocity.sub(d);
            if (velocity.lengthSquared() <= linearAcceleration * timeElapsed) {
                velocity.scale(0);
                stop = false;
            }
        }

        position.add(velocity);

        needsUpdate = velocity.lengthSquared() > 0;

        return position;
    }

    public float getMaxLinearSpeed() {
        return maxLinearSpeed;
    }

    public void setMaxLinearSpeed(float maxLinearSpeed) {
        this.maxLinearSpeed = maxLinearSpeed;
    }

    public float getMaxAngularSpeed() {
        return maxAngularSpeed;
    }

    public void setMaxAngularSpeed(float maxAngularSpeed) {
        this.maxAngularSpeed = maxAngularSpeed;
    }

    public float getLinearAcceleration() {
        return linearAcceleration;
    }

    public void setLinearAcceleration(float linearAcceleration) {
        this.linearAcceleration = linearAcceleration;
    }

    public float getAngularAcceleration() {
        return angularAcceleration;
    }

    public void setAngularAcceleration(float angularAcceleration) {
        this.angularAcceleration = angularAcceleration;
    }

    public float rotateLeft(float fraction) {
        float current = orientation;
        orientation += maxAngularSpeed * fraction;
        updateRotation();
        needsUpdate = current != orientation;
        return orientation;
    }

    private void updateRotation() {
        forward = GlMath.rotate(orientation, GlMath.VECTOR_UP, GlMath.VECTOR_FORWARD);
    }

    public float rotateRight(float fraction) {
        orientation -= maxAngularSpeed * fraction;
        updateRotation();
        return orientation;
    }

    public void translate() {
        GlTools.gl().glTranslatef(position.x, position.y, position.z);
    }

    public void rotate() {
        GlTools.gl().glRotatef(orientation, 0, 1, 0);
    }

    public Vector3f getForward() {
        return forward;
    }

    public void transform(float timeElapsed) {
        update(timeElapsed);
        translate();
        rotate();
    }

    public void updateCamera(DefaultGLWindow current) {
        if (needsUpdate) {
            // Obter a camera atual
            Camera camera = Cameras.getCurrent();

            // O novo eye da camera vai ser relativa à posição do wheatley
            // Movê-lo para trás na direção do "FORWARD"
            // Um pouco para cima (y+)
            camera.eye = new Vector3f(getPosition());
            camera.eye.sub(getForward());
            camera.eye.y += 1.0f;

            // Olhar um pouco à frente do wheatley
            camera.at = new Vector3f(getPosition());
            camera.at.add(getForward());

            // Forçar a atualização da camera
            current.setupCamera();
        }
    }

    public Vector3f getAcceleration() {
        return acceleration;
    }
}

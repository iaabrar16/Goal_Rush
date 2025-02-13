package goalrush;

import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

import static goalrush.App.HEIGHT;
import static goalrush.App.WIDTH;
import static java.lang.Math.sqrt;

import javafx.scene.paint.Color;

public class PlayField {

        private final double H5 = HEIGHT / 5;
        private final double H2 = HEIGHT / 2;
        private final double SQ2 = (H2 * sqrt(3)) / 2;
        private final double W2 = WIDTH / 2;
        private final double H4 = HEIGHT / 4;

        private enum GoalType {
                BLUE, YELLOW, RED
        };

        public Polyline goalB;
        public Polyline goalY;
        public Polyline goalR;

        public Circle ground;
        public Polyline goal;
        public Polygon field;

        public PlayField(Elements list, Color[] colors) {

                goalB = createGoal(GoalType.BLUE, colors);
                goalY = createGoal(GoalType.YELLOW, colors);
                goalR = createGoal(GoalType.RED, colors);

                ground = new Circle(W2, H2, H2, Color.GRAY);

                field = new Polygon();
                field.getPoints().addAll(W2 - H2, H2,
                                W2 - H4, H2 + SQ2,
                                W2 + H4, H2 + SQ2,
                                W2 + H2, H2,
                                W2 + H4, H2 - (H2 * sqrt(3) / 2),
                                W2 - H4, H2 - SQ2);
                field.setFill(Color.web("#008000", 1.0));
                field.setStroke(Color.WHITE);
                field.setStrokeWidth(5);

                Circle circle = new Circle(W2, H2, HEIGHT / 20, Color.TRANSPARENT);
                circle.setStroke(Color.WHITE);
                circle.setStrokeWidth(2);

                Line leftLine = new Line(W2, H2,
                                midpointX(W2 - H2, W2 - H4),
                                midpointY(H2, H2 - SQ2));
                Line rightLine = new Line(W2, H2,
                                midpointX(W2 + H2, W2 + H4),
                                midpointY(H2, H2 - SQ2));
                Line downLine = new Line(W2, H2,
                                midpointX(W2 + H4, W2 - H4),
                                H2 + (H2 * sqrt(3) / 2));
                leftLine.setStroke(Color.WHITE);
                leftLine.setStrokeWidth(2);
                rightLine.setStroke(Color.WHITE);
                rightLine.setStrokeWidth(2);
                downLine.setStroke(Color.WHITE);
                downLine.setStrokeWidth(2);

                int ARCLENGTH = 180;

                Arc leftArc = new Arc(midpointX(W2 - H2, W2 - H4),
                                midpointY(H2, H2 - SQ2), H5, H5,
                                240,
                                WIDTH / 6.7);
                leftArc.setFill(Color.TRANSPARENT);
                leftArc.setStroke(Color.WHITE);
                leftArc.setStrokeWidth(2);
                leftArc.setLength(ARCLENGTH);

                Arc rightArc = new Arc(midpointX(W2 + H2, W2 + H4),
                                midpointY(H2, H2 - SQ2), H5, H5,
                                120,
                                WIDTH / 6.7);
                rightArc.setFill(Color.TRANSPARENT);
                rightArc.setStroke(Color.WHITE);
                rightArc.setStrokeWidth(2);
                rightArc.setLength(ARCLENGTH);

                Arc downArc = new Arc(midpointX(W2 + H4, W2 - H4),
                                H2 + (H2 * sqrt(3) / 2), H5, H5, 0, WIDTH / 6.7);
                downArc.setFill(Color.TRANSPARENT);
                downArc.setStroke(Color.WHITE);
                downArc.setStrokeWidth(2);
                downArc.setLength(ARCLENGTH);

                list.add(ground);
                list.add(field);

                list.add(circle);
                list.add(leftLine);
                list.add(rightLine);
                list.add(downLine);
                list.add(leftArc);
                list.add(rightArc);
                list.add(downArc);

                list.add(goalB);
                list.add(goalY);
                list.add(goalR);
        }

        private Polyline createGoal(GoalType type, Color[] colors) {

                goal = new Polyline();
                switch (type) {
                        case BLUE:
                                goal.getPoints().addAll(
                                                midpointX(W2 - H2,
                                                                midpointX(W2 - H2,
                                                                                W2 - H4))
                                                                + HEIGHT / 20,
                                                midpointY(H2, midpointY(H2,
                                                                H2 - SQ2))
                                                                + HEIGHT / 40,
                                                midpointX(W2 - H2,
                                                                midpointX(W2 - H2,
                                                                                W2 - H4)),
                                                midpointY(H2, midpointY(H2,
                                                                H2 - SQ2)),
                                                midpointX(W2 - H4,
                                                                midpointX(W2 - H2,
                                                                                W2 - H4)),
                                                midpointY(H2 - SQ2,
                                                                midpointY(H2,
                                                                                H2 - SQ2)),
                                                midpointX(W2 - H4,
                                                                midpointX(W2 - H2,
                                                                                W2 - H4))
                                                                + HEIGHT / 20,
                                                midpointY(H2 - SQ2,
                                                                midpointY(H2, H2
                                                                                - SQ2))
                                                                + HEIGHT / 40);
                                goal.setFill(colors[1]);
                                goal.setStrokeWidth(5);
                                break;
                        case YELLOW:
                                goal.getPoints().addAll(
                                                midpointX(W2 + H2,
                                                                midpointX(W2 + H2,
                                                                                W2 + H4))
                                                                - HEIGHT / 20,
                                                midpointY(H2, midpointY(H2,
                                                                H2 - SQ2))
                                                                + HEIGHT / 40,
                                                midpointX(W2 + H2,
                                                                midpointX(W2 + H2,
                                                                                W2 + H4)),
                                                midpointY(H2, midpointY(H2,
                                                                H2 - SQ2)),
                                                midpointX(W2 + H4,
                                                                midpointX(W2 + H2,
                                                                                W2 + H4)),
                                                midpointY(H2 - SQ2,
                                                                midpointY(H2,
                                                                                H2 - SQ2)),
                                                midpointX(W2 + H4,
                                                                midpointX(W2 + H2,
                                                                                W2 + H4))
                                                                - HEIGHT / 20,
                                                midpointY(H2 - SQ2,
                                                                midpointY(H2, H2
                                                                                - SQ2))
                                                                + HEIGHT / 40);
                                goal.setFill(colors[2]);
                                goal.setStrokeWidth(5);
                                break;
                        case RED:
                                goal.getPoints().addAll(
                                                midpointX(W2 + H4,
                                                                midpointX(W2 + H4,
                                                                                W2 - H4)),
                                                H2 + (H2 * sqrt(3) / 2) - HEIGHT / 20,
                                                midpointX(W2 + H4,
                                                                midpointX(W2 + H4,
                                                                                W2 - H4)),
                                                H2 + (H2 * sqrt(3) / 2),
                                                midpointX(W2 - H4,
                                                                midpointX(W2 + H4,
                                                                                W2 - H4)),
                                                H2 + (H2 * sqrt(3) / 2),
                                                midpointX(W2 - H4,
                                                                midpointX(W2 + H4,
                                                                                W2 - H4)),
                                                H2 + (H2 * sqrt(3) / 2) - HEIGHT / 20);
                                goal.setFill(colors[0]);
                                goal.setStrokeWidth(5);
                                break;
                }
                return goal;
        }

        private double midpointX(double x1, double x2) {
                return (x1 + x2) / 2;
        }

        private double midpointY(double y1, double y2) {
                return (y1 + y2) / 2;
        }
}

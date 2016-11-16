/*
 * MIT License
 *
 * Copyright (c) 2016 Anton Stakhouski
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.stakhouski.anton.stealandrun;

/**
 * Created by archer on 14.11.16.
 */

class Trap {
    private int timeRemain;
    private int x;
    private int y;

    Trap() {
        timeRemain = -1;
    }

    int getTimeRemain() {
        return timeRemain;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setTimeRemain(int time) {
        timeRemain = time;
    }

    void setX(int x_) {
        x = x_;
    }

    void setY(int y_) {
        y = y_;
    }
}

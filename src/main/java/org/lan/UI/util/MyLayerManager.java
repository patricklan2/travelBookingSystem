package org.lan.UI.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyLayerManager implements LayoutManager2 {

    List<Component> components = new ArrayList<>();

    private int interval = 0;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public MyLayerManager(int interval) {
        this.interval = interval;
    }

    public MyLayerManager() {
    }


    @Override
    public void layoutContainer(Container parent) {
        int width = parent.getWidth();

        int x = width / 2;int y = 0;
        for (Component component : components) {

            Dimension preferredSize = component.getPreferredSize();
            int preferredSizeHeight = (int) preferredSize.getHeight();
            int preferredSizeWidth = (int) preferredSize.getWidth();
            component.setBounds(x - preferredSizeWidth / 2,y, preferredSizeWidth, preferredSizeHeight);
            y += interval + (int)preferredSize.getHeight();
        }


    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        components.add(comp);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        components.remove(comp);
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return null;
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }

    @Override
    public void invalidateLayout(Container target) {

    }

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }
}

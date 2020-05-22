package model;

public class Holding {

  public final static String NAME = "Seros Group";
  public final static String PATH = "data/currentData.txt";

  // Basic attributes
  private String name;
  private double value;

  // Companies binary search tree
  private Company firstCompany;

  // Company currently managed by the system
  private Company currentCompany;

  /**
   * @param n
   * @param v
   */
  public Holding(String n, double v) {
    name = n;
    value = v;
  }

  /**
   * 
   * @param c
   */
  public void addCompany(Company c) {

    if (firstCompany == null) {
      firstCompany = c;
    } else {

      addCompany(firstCompany, c);

    }

  }

  private void addCompany(Company current, Company c) {

    if (c.getNit().compareTo(current.getNit()) <= 0) {
      if (current.getLeft() == null) {
        current.setLeft(c);
        current.getLeft().setFather(current);
      } else {
        addCompany(current.getLeft(), c);
      }

    } else {

      if (current.getRight() == null) {
        current.setRight(c);
        current.getRight().setFather(current);
      } else {
        addCompany(current.getRight(), c);
      }
    }

  }

  public Company searchCompany(String nit) {

    if (firstCompany == null) {
      return null;
    } else if (firstCompany.getNit().equals(nit)) {
      return firstCompany;
    }

    return searchCompany(firstCompany, nit);

  }

  private Company searchCompany(Company current, String nit) {

    if (current == null) {

      return null;

    } else if (current.getNit().equals(nit)) {

      return current;

    } else if (current.getNit().compareTo(nit) > 0) {

      if (current.getLeft() == null) {

        return null;

      } else {

        return searchCompany(current.getLeft(), nit);

      }

    } else {

      if (current.getNit().equals(nit)) {

        return current;

      } else {

        return searchCompany(current.getRight(), nit);

      }
    }

  }

  /**
   * 
   * @param nit
   */
  public void sellCompany(String nit) {

    value -= searchCompany(nit).getMoneyValue();

    removeCompany(searchCompany(nit));

  }

  public void removeCompany(Company toRemove) {

    if (toRemove != null) {

      if (toRemove.getRight() == null && toRemove.getLeft() == null) {
        if (toRemove.getFather().getLeft() == toRemove) {
          toRemove.getFather().setLeft(null);
        } else {
          toRemove.getFather().setRight(null);
        }
      } else if (toRemove.getRight() == null ^ toRemove.getLeft() == null) {

        if (toRemove.getRight() != null) {
          if (toRemove.getFather().getRight() == toRemove) {
            toRemove.getRight().setFather(toRemove.getFather());
            toRemove.getFather().setRight(toRemove.getRight());
          } else {
            toRemove.getRight().setFather(toRemove.getFather());
            toRemove.getFather().setLeft(toRemove.getRight());
          }

        } else {

          if (toRemove.getFather().getRight() == toRemove) {
            toRemove.getLeft().setFather(toRemove.getFather());
            toRemove.getFather().setRight(toRemove.getLeft());
          } else {
            toRemove.getLeft().setFather(toRemove.getFather());
            toRemove.getFather().setLeft(toRemove.getLeft());
          }

        }

      } else if (toRemove.getLeft() != null && toRemove.getRight() != null) {

        Company current = toRemove.getLeft();

        while (current.getRight() != null) {

          current = current.getRight();

        }

        if (current.getFather().getRight() == current) {
          current.getFather().setRight(null);

        } else {
          current.getFather().setLeft(null);
        }

        current.setFather(toRemove.getFather());
        current.setLeft(toRemove.getLeft());
        current.setRight(toRemove.getRight());
        current.getRight().setFather(current);
        current.getLeft().setFather(current);

        if (toRemove.getFather().getRight() == toRemove) {
          current.getFather().setRight(current);

        } else {
          current.getFather().setLeft(current);
        }

        current = null;

      }

    }

  }

  /**
   * 
   * @param e
   */
  public void addEmployee(Employee e) {

  }

  /**
   * 
   * @param bO
   */
  public void addBranchOffice(BranchOffice bO) {

  }

  /**
   * 
   * @param c
   */
  public void addContract(Contract c) {

  }

  /**
   * 
   * @return
   */
  public Employee findEmployee(String id) {
    return null;
  }

  /**
   * 
   * @param id
   * @return
   */
  public Contract findContract(String id) {
    return null;
  }

  /**
   * 
   * @param id
   * @return
   */
  public BranchOffice findBranchOffice(String id) {
    return null;
  }

  /**
   * 
   * @param id
   */
  public void removeEmployee(String id) {

  }

  /**
   * 
   * @param id
   */
  public void removeContract(String id) {

  }

  /**
   * 
   * @param id
   */
  public void removeBranchOffice(String id) {

  }

  /**
   * 
   * @param txt
   * @param type
   * @return
   */
  public String generateReport(boolean txt, String type) {
    return "";
  }

  /**
   * 
   */
  public void insertionSortBranchOffices() {

  }

  /**
   * 
   */
  public void bubbleSortContracts() {

  }

  /**
   * 
   */
  public void selectionSortBranchOffices() {

  }

  /**
   * 
   */
  public void loadAttributesFromTxtFile() {

  }

  /**
   * 
   */
  public void loadRelationsFromFile() {

  }

  /**
   * 
   * @return
   */
  public Company getCurrentCompany() {
    return currentCompany;
  }

  /**
   * 
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * 
   * @return
   */
  public double getValue() {
    return value;
  }

  /**
   * 
   * @return
   */
  public Company getFirstCompany() {
    return firstCompany;
  }

  public void setCurrentCompany(Company currentCompany) {
    this.currentCompany = currentCompany;
  }
}
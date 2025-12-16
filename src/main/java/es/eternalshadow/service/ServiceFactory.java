package es.eternalshadow.service;

import es.eternalshadow.main.GameContext;

public class ServiceFactory {
	private final UserService userService;
    private final MenuService menuService;
    private final EULAService eulaService;
    private final GameService gameService;
    private final CapitulosLoader cloader;
	
    public ServiceFactory(GameContext context) {
		super();
		this.userService = new UserService(context);
        this.menuService = new MenuService(context);
        this.eulaService = new EULAService("./docs/eula.txt");
        this.gameService = new GameService(context);
		this.cloader = new CapitulosLoader(context);
	}
    
    public UserService getUserService() {
        return userService;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public EULAService getEulaService() {
        return eulaService;
    }

    public GameService getGameService() {
        return gameService;
    }

	public CapitulosLoader getCapitulosLoader() {
		return cloader;
	}
}

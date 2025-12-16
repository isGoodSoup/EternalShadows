package es.eternalshadow.service;

import es.eternalshadow.main.GameContext;

public class ServiceFactory {
	private GameContext context;
	private final UserService userService;
    private final MenuService menuService;
    private final EULAService eulaService;
    private final GameService gameService;
    private CapitulosLoader capitulosLoader;
	
    public ServiceFactory() {
		super();
		this.userService = new UserService(null);
        this.menuService = new MenuService(null);
        this.eulaService = new EULAService("./docs/eula.txt");
        this.gameService = new GameService(null);
		this.capitulosLoader = new CapitulosLoader(null);
	}
    
    public void init(GameContext context) {
        this.context = context;	
        this.userService.setContext(context);
        this.menuService.setContext(context);
        this.gameService.setContext(context);
        this.capitulosLoader = new CapitulosLoader(context);
    }
    
    public GameContext getContext() {
		return context;
	}

	public void setContext(GameContext context) {
		this.context = context;
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
		return capitulosLoader;
	}

	public void setCapitulosLoader(CapitulosLoader capitulosLoader) {
		this.capitulosLoader = capitulosLoader;
	}
}
